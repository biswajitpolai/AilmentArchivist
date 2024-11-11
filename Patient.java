import java.sql.*;

class Patients 
{
    private int patientId;
    private String date;
    private String name;
    private String mentalHealth;
    private double height, weight, bloodPressureSys, bloodPressureDias, sugarFasting, sugarPostMeal;
    private float redCellCount, whiteCellCount, haemoglobin, pH, glucose, protein, bilirubin, blood, leukocytes;
    private float BMI;
    private String htWtCheck, BPCheck, sugarCheck, CBCCheck, urineCheck;

    private static final String URL = "jdbc:mysql://localhost:3306/lab_management";
    private static final String USER = "root";
    private static final String PASSWORD = "qwerty@21";

    public Patients (int patientId, String date, String name, double height, double weight, double bloodPressureSys,
                   double bloodPressureDias, double sugarFasting, double sugarPostMeal, float redCellCount,
                   float whiteCellCount, float haemoglobin, float pH, float glucose, float protein,
                   float bilirubin, float blood, float leukocytes, String mentalHealth) {
        this.patientId = patientId;
        this.date = date;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bloodPressureSys = bloodPressureSys;
        this.bloodPressureDias = bloodPressureDias;
        this.sugarFasting = sugarFasting;
        this.sugarPostMeal = sugarPostMeal;
        this.redCellCount = redCellCount;
        this.whiteCellCount = whiteCellCount;
        this.haemoglobin = haemoglobin;
        this.pH = pH;
        this.glucose = glucose;
        this.protein = protein;
        this.bilirubin = bilirubin;
        this.blood = blood;
        this.leukocytes = leukocytes;
        this.mentalHealth = mentalHealth;
        calculate();
    }

    private void calculate()
    {
        BMI = (float) (weight / (height * height));
        if (BMI <= 18.5)
            htWtCheck = "underweight";
        else if (BMI > 18.5 && BMI <= 24.9)
            htWtCheck = "normal weight";
        else if (BMI > 24.9 && BMI <= 29.9)
            htWtCheck = "overweight";
        else if (BMI > 29.9 && BMI <= 34.9)
            htWtCheck = "class I obesity";
        else if (BMI > 34.9 && BMI <= 39.9)
            htWtCheck = "class II obesity";
        else
            htWtCheck = "class III obesity";

        if (bloodPressureSys <= 120 && bloodPressureDias < 80)
            BPCheck = "Healthy";
        else if ((bloodPressureSys > 120 && bloodPressureSys <= 129) && bloodPressureDias < 80)
            BPCheck = "Elevated";
        else if ((bloodPressureSys > 129 && bloodPressureSys <= 139) && (bloodPressureDias > 80 && bloodPressureDias <= 89))
            BPCheck = "Stage I hypertension";
        else if (bloodPressureSys >= 140 && bloodPressureDias >= 90)
            BPCheck = "Stage II hypertension";
        else if (bloodPressureSys >= 180 && bloodPressureDias >= 120)
            BPCheck = "Hypertension crisis";
        else
            BPCheck = "Abnormal";

        if ((sugarFasting >= 70 && sugarFasting <= 100) && (sugarPostMeal >= 70 && sugarPostMeal <= 140))
            sugarCheck = "Normal";
        else if ((sugarFasting > 100 && sugarFasting <= 125) && (sugarPostMeal > 140 && sugarPostMeal <= 200))
            sugarCheck = "Pre-Diabetes";
        else if ((sugarFasting > 125) && (sugarPostMeal > 200))
            sugarCheck = "Diabetes";
        else
            sugarCheck = "Abnormal";

        if ((redCellCount >= 4.5 && redCellCount <= 5.7) && (whiteCellCount >= 4.0 && whiteCellCount <= 10.0) && (haemoglobin >= 133 && haemoglobin <= 167)) {
            CBCCheck = "Normal";
        } else {
            CBCCheck = "Abnormality consult doctor";
        }

        if ((pH >= 5 && pH <= 9) && (glucose < 20) && (protein < 20) && (bilirubin < 1.80) && (blood < 0.02) && (leukocytes >= 15 && leukocytes <= 40)) {
            urineCheck = "Normal";
        } else {
            urineCheck = "Abnormal consult doctor";
        }
    }

    public void saveToDatabase() 
    {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO patients (patient_id, date, name, height, weight, blood_pressure_sys, blood_pressure_dias, sugar_fasting, sugar_post_meal, red_cell_count, white_cell_count, haemoglobin, pH, glucose, protein, bilirubin, blood, leukocytes, BMI, ht_wt_check, BP_check, sugar_check, CBC_check, urine_check, mental_health) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, patientId);
            pstmt.setString(2, date);
            pstmt.setString(3, name);
            pstmt.setDouble(4, height);
            pstmt.setDouble(5, weight);
            pstmt.setDouble(6, bloodPressureSys);
            pstmt.setDouble(7, bloodPressureDias);
            pstmt.setDouble(8, sugarFasting);
            pstmt.setDouble(9, sugarPostMeal);
            pstmt.setFloat(10, redCellCount);
            pstmt.setFloat(11, whiteCellCount);
            pstmt.setFloat(12, haemoglobin);
            pstmt.setFloat(13, pH);
            pstmt.setFloat(14, glucose);
            pstmt.setFloat(15, protein);
            pstmt.setFloat(16, bilirubin);
            pstmt.setFloat(17, blood);
            pstmt.setFloat(18, leukocytes);
            pstmt.setFloat(19, BMI);
            pstmt.setString(20, htWtCheck);
            pstmt.setString(21, BPCheck);
            pstmt.setString(22, sugarCheck);
            pstmt.setString(23, CBCCheck);
            pstmt.setString(24, urineCheck);
            pstmt.setString(25, mentalHealth);
            
            pstmt.executeUpdate();
            System.out.println("Patient record saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayAll()
    {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM patients";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("patient_id");
                String date = rs.getString("date");
                String name = rs.getString("name");
                double height = rs.getDouble("height");
                double weight = rs.getDouble("weight");
                double bloodPressureSys = rs.getDouble("blood_pressure_sys");
                double bloodPressureDias = rs.getDouble("blood_pressure_dias");
                double sugarFasting = rs.getDouble("sugar_fasting");
                double sugarPostMeal = rs.getDouble("sugar_post_meal");
                float redCellCount = rs.getFloat("red_cell_count");
                float whiteCellCount = rs.getFloat("white_cell_count");
                float haemoglobin = rs.getFloat("haemoglobin");
                float pH = rs.getFloat("pH");
                float glucose = rs.getFloat("glucose");
                float protein = rs.getFloat("protein");
                float bilirubin = rs.getFloat("bilirubin");
                float blood = rs.getFloat("blood");
                float leukocytes = rs.getFloat("leukocytes");
                float BMI = rs.getFloat("BMI");
                String htWtCheck = rs.getString("ht_wt_check");
                String BPCheck = rs.getString("BP_check");
                String sugarCheck = rs.getString("sugar_check");
                String CBCCheck = rs.getString("CBC_check");
                String urineCheck = rs.getString("urine_check");
                String mentalHealth = rs.getString("mental_health");

                System.out.println("\nPatient ID: " + id);
                System.out.println("Report Date: " + date);
                System.out.println("Patient Name: " + name);
                System.out.println("Height: " + height);
                System.out.println("Weight: " + weight);
                System.out.println("Systolic/Diastolic Blood Pressure: " + bloodPressureSys + "/" + bloodPressureDias);
                System.out.println("Fasting/Post Meal Blood Sugar Levels: " + sugarFasting + "/" + sugarPostMeal);
                System.out.println("Red Cell Count: " + redCellCount);
                System.out.println("White Cell Count: " + whiteCellCount);
                System.out.println("Haemoglobin: " + haemoglobin);
                System.out.println("pH: " + pH);
                System.out.println("Glucose: " + glucose);
                System.out.println("Protein: " + protein);
                System.out.println("Bilirubin: " + bilirubin);
                System.out.println("Blood: " + blood);
                System.out.println("Leukocytes: " + leukocytes);
                System.out.println("BMI: " + BMI);
                System.out.println("BMI Status: " + htWtCheck);
                System.out.println("Blood Pressure Status: " + BPCheck);
                System.out.println("Sugar Level Status: " + sugarCheck);
                System.out.println("CBC Test Status: " + CBCCheck);
                System.out.println("Urine Test Status: " + urineCheck);
                System.out.println("Mental Health Status: " + mentalHealth);
                System.out.println("==========================================");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void deletePatient(int id) 
    {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "DELETE FROM patients WHERE patient_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Patient record deleted successfully.");
            } else {
                System.out.println("Patient record not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
