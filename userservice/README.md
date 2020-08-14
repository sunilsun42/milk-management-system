# userservice
 
sudo docker run --name mysql -e MYSQL_ROOT_PASSWORD=admin -d mysql:5.7.27


sudo docker run --name mysql2 --publish 0.0.0.0:3306:3306 -e MYSQL_ROOT_PASSWORD=admin -d mysql:5.7.27

sudo docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mysql2


mysql -uroot -p


sudo docker exec -it mysql2 bash



 Setting up kafka cluster woth Zookeeper :
 
 create a docker-compose.yml dile in kafka-docker:

version: '2'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"
  kafka:
   image: wurstmeister/kafka
    ports:
      - "9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 192.168.152.131
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
	  
   
   This will create single zookeeper instance with one kafka instance.
	  
	  
use  sudo docker-compose scale kafka=3  to create thre kafka brokers in the cluster
 
 
 
 
 
 
