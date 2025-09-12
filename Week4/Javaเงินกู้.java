import java.util.Scanner;

public class Javaเงินกู้ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // รับข้อมูลจากผู้ใช้
        System.out.println("=== โปรแกรมคำนวณเงินกู้ ===");
        
        System.out.print("กรุณาใส่ยอดเงินกู้ (บาท): ");
        double principal = scanner.nextDouble();
        
        System.out.print("กรุณาใส่อัตราดอกเบี้ยต่อปี (%): ");
        double annualRate = scanner.nextDouble();
        
        System.out.print("กรุณาใส่ระยะเวลาเงินกู้ (ปี): ");
        int years = scanner.nextInt();
        
        // คำนวณอัตราดอกเบี้ยต่อเดือน
        double monthlyRate = annualRate / 100 / 12;
        
        // คำนวณจำนวนงวดทั้งหมด (เดือน)
        int totalMonths = years * 12;
        
        // คำนวณเงินงวดต่อเดือนโดยใช้สูตร
        // M = P * [i(1+i)^n] / [(1+i)^n - 1]
        double monthlyPayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, totalMonths)) 
                               / (Math.pow(1 + monthlyRate, totalMonths) - 1);
        
        // แสดงผลลัพธ์
        System.out.printf("\n=== ผลการคำนวณ ===");
        System.out.printf("\nยอดเงินกู้: %.2f บาท", principal);
        System.out.printf("\nอัตราดอกเบี้ยต่อปี: %.2f%%", annualRate);
        System.out.printf("\nระยะเวลา: %d ปี", years);
        System.out.printf("\nเงินงวดต่อเดือน: %.2f บาท", monthlyPayment);
        
        scanner.close();
    }
}
