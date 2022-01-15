const express = require('express')
const app = express()
const mongoClient = require('mongodb').MongoClient

const url = "mongodb://localhost:27017"

app.use(express.json())

mongoClient.connect(url, (err, db) => {

    if (err) {
        console.log("Error while connecting mongo client")
    } else {

        const myDb = db.db('myDb')
        const collection = myDb.collection('myTable')

        app.post('/signup', (req, res) => {

            const newUser = {
                username: req.body.username,
                email: req.body.email,
                password: req.body.password
            }

            const query = { email: newUser.email }

            collection.findOne(query, (err, result) => {

                if (result == null) {
                    collection.insertOne(newUser, (err, result) => {
                        res.status(200).send()
                        console.log(req.body)
                    })
                } else {
                    res.status(400).send()
                }

            })

        })

        app.post('/login', (req, res) => {

            const query = {
                username: req.body.username,
                password: req.body.password
            }

            collection.findOne(query, (err, result) => {

                if (result != null) {

                    const objToSend = {
                        username: result.username,
                        password: result.password
                    }

                    res.status(200).send(JSON.stringify(objToSend))

                } else {
                    res.status(404).send()
                }

            })

        })

        app.post('/newTask', (req, res) => {

            const newTask = {
                task: req.body.task,
                task1: req.body.task1,
                task2: req.body.task2,
                task3: req.body.task3,
                task4: req.body.task4,
                task5: req.body.task5,
            }

            const query = { task: newTask.task }

            collection.findOne(query, (err, result) => {

                if (result == null) {
                    collection.insertOne(newTask, (err, result) => {
                        res.status(200).send()
                        console.log(req.body);
                    })
                } else {
                    res.status(400).send()
                }

            })

        })

    }

})

app.listen(5001, () => {
    console.log("Listening on port 5001...")
})