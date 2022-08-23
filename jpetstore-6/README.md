# README
The 'JPetstore' in this repository is configured for generating execution traces using 'Kiker Tool'. The changes made to the original 'JPetstore' project is as follows:

1. Filter configuration added in  web.xml file located in jpetstore-6/src/main/webapp/WEB-INF
<filter>
        <filter−name>sessionAndTraceRegistrationFilter</filter−name>
        <filter−class>kieker.monitoring.probe.servlet.SessionAndTraceRegistrationFilter</filter−class>
        <init−param>
                <param−name>logFilterExecution</param−name>
                <param−value>true</param−value>
        </init−param>
</filter>
<filter−mapping>
        <filter−name>sessionAndTraceRegistrationFilter</filter−name>
        <url−pattern>/∗</url−pattern>
</filter−mapping>

2. aop.xml file created and placed in src/main/resources
<!DOCTYPE aspectj PUBLIC "−//AspectJ//DTD//EN" "http://www.aspectj.org/dtd/aspectj_1_5_0.dtd">
<aspectj>
        <weaver options="">
                <include within="org.mybatis..*"/>
        </weaver>
        <aspects>
                <aspect name="kieker.monitoring.probe.aspectj.operationExecution.OperationExecutionAspectFull"/>
        </aspects>
</aspectj>

3. In the dependency section of the pom.xml added:
<dependency>
        <groupId>net.kieker-monitoring</groupId>
        <artifactId>kieker</artifactId>
        <version>1.14</version>
</dependency>
<dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjrt</artifactId>
        <version>1.8.7</version>
</dependency>

4. In the build section of the pom.xml added:
<plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>aspectj-maven-plugin</artifactId>
        <version>1.8</version>
        <configuration>
                <source>1.7</source>
                <target>1.7</target>
                <complianceLevel>1.7</complianceLevel>
                <aspectLibraries>
                        <aspectLibrary>
                                <groupId>net.kieker-monitoring</groupId>
                                <artifactId>kieker</artifactId>
                        </aspectLibrary>
                </aspectLibraries>
                <xmlConfigured>${basedir}/src/main/resources/aop.xml</xmlConfigured>
                <sources>
                        <source>
                                <basedir>${basedir}/src/main/java</basedir>
                                <includes>
                                        <include>**/**.java</include>
                                </includes>
                        </source>
                </sources>
        </configuration>
        <executions>
                <execution>
                        <goals>
                                <goal>compile</goal>
                        </goals>
                </execution>
        </executions>
</plugin>

5. The kieker.monitoring.properties file  contain the following information and is placed in src/main/resources/META-INF/ within the project directory.
## The name of the Kieker instance.
kieker.monitoring.name=KIEKER

## Whether a debug mode is activated.
kieker.monitoring.debug=false

## Enable monitoring after startup
kieker.monitoring.enabled=true

## The name of the VM running Kieker or empty (will automatically be
resolved)
kieker.monitoring.hostname=

## Automatically add a metadata record
kieker.monitoring.metadata=true

## Enables the automatic assignment
kieker.monitoring.setLoggingTimestamp=true

## Register shutdown hook
kieker.monitoring.useShutdownHook=true

## Do not use JMX
kieker.monitoring.jmx=false

## The size of the thread pool used to execute registered periodic sensor jobs.
kieker.monitoring.periodicSensorsExecutorPoolSize=0

## Disable adaptive monitoring.
kieker.monitoring.adaptiveMonitoring.enabled=false

## Timer to use
kieker.monitoring.timer=kieker.monitoring.timer.SystemNanoTimer

## Report timestamps in
## Accepted values:
## 0 - nanoseconds
## 1 - microseconds
## 2 - milliseconds
## 3 - seconds
kieker.monitoring.timer.SystemMilliTimer.unit=0

## Writer configuration
kieker.monitoring.writer=kieker.monitoring.writer.filesystem.FileWriter

## output path
kieker.monitoring.writer.filesystem.FileWriter.customStoragePath=$LOGGING_DIR/
kieker.monitoring.writer.filesystem.FileWriter.charsetName=UTF-8

## Number of entries per file
kieker.monitoring.writer.filesystem.FileWriter.maxEntriesInFile=25000

## Limit of the log file size; -1 no limit
kieker.monitoring.writer.filesystem.FileWriter.maxLogSize=-1

## Limit number of log files; -1 no limit
kieker.monitoring.writer.filesystem.FileWriter.maxLogFiles=-1

## Map files are written as text files
kieker.monitoring.writer.filesystem.FileWriter.mapFileHandler=kieker.monitoring.writer.filesystem.TextMapFileHandler

## Flush map file after each record
kieker.monitoring.writer.filesystem.TextMapFileHandler.flush=true

## Do not compress the map file
kieker.monitoring.writer.filesystem.TextMapFileHandler.compression=kieker.monitoring.writer.compression.NoneCompressionFilter

## Log file pool handler
kieker.monitoring.writer.filesystem.FileWriter.logFilePoolHandler=kieker.monitoring.writer.filesystem.RotatingLogFilePoolHandler

## Text log for record data
kieker.monitoring.writer.filesystem.FileWriter.logStreamHandler=kieker.monitoring.writer.filesystem.TextLogStreamHandler

## Do not compress the log file
kieker.monitoring.writer.filesystem.TextLogStreamHandler.compression=kieker.monitoring.writer.compression.NoneCompressionFilter

## Flush log data after every record
kieker.monitoring.writer.filesystem.FileWriter.flush=true

## buffer size. The log buffer size must be big enough to hold the biggest record
kieker.monitoring.writer.filesystem.FileWriter.bufferSize=81920

6. The configurations for each operation is also changed for generating the logs.

7. mvn clean compile package

8. This maven application was tested by running it on a Apache Tomcat 8.5 and JDK version 16.

