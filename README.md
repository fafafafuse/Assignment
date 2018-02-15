# Assignment
the source code for sending the assignment to MFEC.

หลักการทำงานส่วน JAVA (CalPhoneCost)
1. ReadFromFile.java จะรับไฟล์ promotion1.log เข้ามา แล้วแปลงรูปแบบเป็น String JSON
2. นำ String JSON ที่ได้มาทำเป็น JSONArray และ ใช้ JSONObject อ้างถึง Object แต่ละตัวใน JSONArray มา assign ลงใน Object ของ CallingHistory
3. CallingHistory.java เป็นคลาสที่เอาไว้รองรับสำหรับ Object JSON แต่ละตัวเพื่อนำมาคำนวณอีกต่อนึง
4. ใช้ method CalcCost(CallingHistory phone) เพื่อคำนวณหาค่าโทรศัพท์ของแต่ละเบอร์ แล้วมา assign กลับไปที่ Object ของ CallingHistory อีกรอบ
5. ใช้ GSON ในการแปลง object ของ CallingHistory เป็น JSON และเขียนเป็นไฟล์ PhoneCallingCost.json ออกมาไว้ใน read-json/src

ส่วน React (read-json) - ทำหน้าเว็บง่ายๆ import ไฟล์ PhoneCallingCost.json แล้วนำมาแสดงในรูปแบบของตาราง
