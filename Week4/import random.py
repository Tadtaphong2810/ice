import random

def roll_dice():
    """ฟังก์ชันสำหรับทอยลูกเต๋า 6 หน้า"""
    return random.randint(1, 6)

def main():
    """ฟังก์ชันหลักของโปรแกรม"""
    print("=== โปรแกรมทอยลูกเต๋า 6 หน้า ===")
    print("กด Enter เพื่อทอยลูกเต๋า (พิมพ์ 'q' เพื่อออก)")
    
    while True:
        user_input = input("\nกด Enter เพื่อทอยลูกเต๋า: ")
        
        if user_input.lower() == 'q':
            print("ขอบคุณที่ใช้โปรแกรม!")
            break
        
        # ทอยลูกเต๋าและแสดงผลลัพธ์
        result = roll_dice()
        print(f"ผลลัพธ์: {result}")

if __name__ == "__main__":
    main()
