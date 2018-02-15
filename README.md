# mfec-assignment
the source code for sending the assignment to MFEC.

CallingHistory.java เป็น class ที่ทำไว้เพื่อเตรียมรับข้อมูลจาก log มาเก็บเป็น Object

ReadFromFile.java 
1.จะแปลง log เป็น json ก่อน โดยใช้ BufferReader อ่านทีละบรรทัด แล้วตัดข้อมลแต่ละช่วงเพื่อมา re-format ใหม่เป็น json
2.ใช้ JSONArray มาเก็บ json ไว้เพื่อเอามาloop for ใช้ JSONObject แยกแต่ละตัวมา set ลงใน object ของคลาส CallingHistory
3.
