from turtle import circle
import mysql.connector

my_con = mysql.connector.connect(
    host="remotemysql.com",
    user="bPHiiRCWTe",
    passwd="Ftl2nnrmAp",
    database="bPHiiRCWTe"
)
print('Connect to MYSQL\n')
cursor = my_con.cursor()

# 1.3
print("[1.3]")
cursor.execute ("SELECT * FROM characters  WHERE animeFK = 12")
for x in cursor :
    print(x[0], x)

print("\n[1.4]")
# 1.4
try:
    cursor.execute("""INSERT INTO characters (id, fName, lName, popularity, animeFK) VALUES (503680, 'Thanapat', 'Viper', 9999, 11)""")
    my_con.commit()
    print("INSERT SUCCESS\n")
except:
    print("INSERT FAIL\n")

print("[1.5]")
# 1.5
cursor.execute("SELECT * FROM anime INNER JOIN characters ON anime.id = characters.animeFK WHERE title = 'demon slayer'")
for x in cursor:
    print(x[0], x)

cursor.close()
my_con.close()