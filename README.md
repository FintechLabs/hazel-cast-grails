#### You can find the details about HazelCast and related clode by referring the below mentioned resources:

PPT: https://www.slideshare.net/NexThoughts/hazelcast-120807730

Github Repository: https://github.com/FintechLabs/hazel-cast-grails
 
Here we'll see how to configure and have HazelCast running on our system whether it's local system or server as well.
1. First go to HazelCast Website(https://hazelcast.org/download/) and download HazelCast IMDG latest build and also HazelCast Management Center latest build zip/tar from there.
Note: For the latest you must have Java 8 installed on your system. If you have Java verison prior to this then check the version of Hazelcast compatible with your Java version on HazelCast website.
 
2. Unzip both zip/tar files on your system.
3. You can pretty much fire up management center without any configuration except mentioning the port and context on which it'll run. To do so just browse inside the unzipped folder of man-center and then fire up this simple command(start.sh <PORT> <CONTEXT_PATH> | e.g. start.sh 8099 hazelcast-mancenter).
4. Now it's time to fire up HazelCast nodes so to do that first browse inside the unzipped folder of hazelcast then browse insise the bin folder as well. Inside here you will see couple of files like hazelcast.xml and some shell scripts.
5. Now it's time to update the hazelcast.xml file to configure HazelCast for our use. Refer below link for the content of this file with updated configuration.
https://pastebin.com/0jGiRVic
6. Now It's time to fire up this configured node. It can be done just by executing start.sh script which can be located inside bin folder the same location as of hazelcast.xml file.
 
To make sure the whole setup is up and running, You just have to open the url of the hazelcast management center in the browser and then the hazelcast node must be listed there.
