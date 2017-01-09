mvn package -Dmaven.test.skip=true docker:build

docker tag recognize/recognition 033150149688.dkr.ecr.us-west-2.amazonaws.com/recognition:latest

docker push 033150149688.dkr.ecr.us-west-2.amazonaws.com/recognition:latest

(copypaste login command if needed)

eb deploy
