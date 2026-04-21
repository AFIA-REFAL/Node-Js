const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const studentRoutes = require('./routes/studentRoutes');

const app = express();

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Routes
app.use('/api', studentRoutes);

// Start server
app.listen(3000, () => {
    console.log('Server running on http://localhost:3000');
});