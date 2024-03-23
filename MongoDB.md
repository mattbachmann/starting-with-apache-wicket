# MongoDB setup

1Start docker container:
`
docker run --name mongodb -e MONGO_INITDB_DATABASE=wicket_course \
-p 27017:27017 \
-v /tmp/mongo-data:/data/db mongo:3.4.2
`
Connect to data source and type:
```db.getName()```
