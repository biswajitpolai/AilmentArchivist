  create database patient_management ;
  USE patient_management;
  CREATE TABLE patients (
    patient_id INT PRIMARY KEY,
    date VARCHAR(10),
    name VARCHAR(50),patients
    height DOUBLE,
    weight DOUBLE,
    blood_pressure_sys DOUBLE,
    blood_pressure_dias DOUBLE,
    sugar_fasting DOUBLE,
    sugar_post_meal DOUBLE,
    red_cell_count FLOAT,
    white_cell_count FLOAT,
    haemoglobin FLOAT,
    pH FLOAT,
    glucose FLOAT,
    protein FLOAT,
    bilirubin FLOAT,
    blood FLOAT,
    leukocytes FLOAT,
    BMI FLOAT,
    ht_wt_check VARCHAR(30),
    BP_check VARCHAR(30),
    sugar_check VARCHAR(30),
    CBC_check VARCHAR(30),
    urine_check VARCHAR(30),
    mental_health VARCHAR(150)
);
