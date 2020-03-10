$var = $(get-item ${PWD}).parent.FullName
$pathProject = $var + "\backend"
$pathJar = $pathProject + "\target"



docker run -it --rm --name swapit -v ${pathProject}:/usr/src/mymaven -w /usr/src/mymaven maven mvn clean package -DskipTests

#Move jar to actual directory, delete if exist
$appJar = "swapit_server-0.0.1-SNAPSHOT.jar"
Remove-Item ${appJar}
Move-Item ${pathJar}/swapit_server-0.0.1-SNAPSHOT.jar .


docker build -t davidrobl/prueba4 .