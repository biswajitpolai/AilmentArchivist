public class PatientManagementSystem {
    public static void main(String[] args) {
      
        Patients patients = new Patients (1, "01/01/2022", "Padma charan polai", 1.75, 70, 120, 80, 90, 140, 4.6f, 9.0f, 150.0f, 6.0f, 5.0f, 15.0f, 1.5f, 0.01f, 25.0f, "Good mental health");
        Patients polai = new Patients (2, "02/01/2022", "Biswajit polai", 2.75, 89, 140, 80, 100, 140, 4.6f, 9.0f, 150.0f, 6.0f, 5.0f, 15.0f, 2.5f, 0.01f, 26.0f, "Good mental health");
        
        patients.saveToDatabase();
        polai.saveToDatabase();
       
      patients.displayAll();
      polai.displayAll();

       
       patients.deletePatient(1);
        polai.deletePatient(2);
    }
}
