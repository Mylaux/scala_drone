USAGE
=====

```
$ git clone https://github.com/Mylaux/scala_drone.git
```
To run the project you need two terminals:
1. First one will be your server:
* go to the server directory
* launch it using SBT and let it be
```
$ cd scala_drone/server
$ sbt run
```
2. Second one will be the client

* open a new terminal
* go to the client direcory

```
$ cd scala_drone/client
```

Client usage
------------
Two commands are available on the client side:
```
sbt "run init <nb> <path>"
```
This command will create **nb** randoms drones at **path** with a **json** format.

Then simulate the drones by typing:
```
sbt "run start <path>" 
```
and let it run.

**N.B.**: The first time you launch it, the client may crash so you may have to redo this command again.

Monitoring
----------

Once the **server** and the **client** are running you can follow the simulation:
* open a web browser
* go to <http://localhot:9000>

