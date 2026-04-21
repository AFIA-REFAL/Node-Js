const model = require('../models/studentModel');

exports.getStudents = (req, res) => {
    model.getAll((err, results) => {
        if (err) res.status(500).send(err);
        else res.json(results);
    });
};

exports.getStudent = (req, res) => {
    model.getById(req.params.id, (err, results) => {
        if (err) res.status(500).send(err);
        else res.json(results);
    });
};

exports.createStudent = (req, res) => {
    model.create(req.body, (err, result) => {
        if (err) res.status(500).send(err);
        else res.send("Student created");
    });
};

exports.updateStudent = (req, res) => {
    model.update(req.params.id, req.body, (err, result) => {
        if (err) res.status(500).send(err);
        else res.send("Student updated");
    });
};

exports.deleteStudent = (req, res) => {
    model.delete(req.params.id, (err, result) => {
        if (err) res.status(500).send(err);
        else res.send("Student deleted");
    });
};