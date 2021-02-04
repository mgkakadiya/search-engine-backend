# search engine backend

Tip: [Github repository](https://github.com/mgkakadiya/search-engine-backend)

## Local Setup:

#### Download and install for your platform:

1. **JDK 8**: [JDK8 Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. **Maven**: [Maven Download](https://maven.apache.org/index.html)
3. **Git**: [Git SCM Download](https://git-scm.com/downloads)
4. **hsqldb**: [HSQLDB Download and setup](https://www.tutorialspoint.com/hsqldb/hsqldb_installation.htm)  
   Set the username as `sa` and password as ` ` (blank). You can set it to whatever you want but make sure to
   update `application.properties` appropriately to make a successful db connection.

#### Setup steps in local machine:

1) Open `hsqldb` folder where you install it and start server
   `C:\program file\hsqldb-2.5.1\hsqldb>java -classpath lib/hsqldb.jar org.hsqldb.server.Server`
2) Create a new database, for that run command on open cmd
   `C:\program file\hsqldb-2.5.1\hsqldb>java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.1 file:hsqldb/search-engine --dbname.1 search-engine`
3) Clone the project: `git clone https://github.com/mgkakadiya/search-engine-backend.git`.
4) Go inside project directory and Build the Project: `mvn clean install`
5) EDIT your application.properties file and update the database name,username password and datasource url
6) Start backend server run main method of `SearchEngineApplication.Java` class