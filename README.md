# webcam-capture-openimaj-mac-catalina
For working under MAC OSX 10.15 catalina with OpenIMAJ driver for camera permission issue

Based on https://github.com/openimaj/openimaj/issues/170 issue description and using http://jenkins.ecs.soton.ac.uk/job/OpenIMAJ/5463/ (http://jenkins.ecs.soton.ac.uk/job/OpenIMAJ/5463/org.openimaj$core-video-capture/) http://jenkins.ecs.soton.ac.uk/job/OpenIMAJ/5463/org.openimaj$core-video-capture/artifact/org.openimaj/core-video-capture/1.4-SNAPSHOT/core-video-capture-1.4-SNAPSHOT.jar

In order to work with BridJ, using http://maven.ecs.soton.ac.uk/content/groups/maven.openimaj.org/com/nativelibs4java/bridj/0.7-20140918-2/ for building webcam-capture by Sarxos.

After testing, this example works with buildin Camera and external UVC camera via USB connection.
