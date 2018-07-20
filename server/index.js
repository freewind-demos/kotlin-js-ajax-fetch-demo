const express = require('express');
const bodyParser = require('body-parser');

const app = express();

// for parsing application/json
app.use(bodyParser.json());

app.use(express.static('./public'))

app.get('/data.json', function(req, res) {
    console.log('GET /data.json')
    res.type('json').send({
        method: 'GET',
        user: 'Freewind'
    })
});

app.post('/data.json', function(req, res) {
    console.log('POST /data.json')
    console.log(req.body)
    res.type('json').send({
        method: 'POST',
        user: 'Freewind',
        clientData: req.body.clientData
    })
});

app.listen(3000, function() {
    console.log('Listening on 3000');
});