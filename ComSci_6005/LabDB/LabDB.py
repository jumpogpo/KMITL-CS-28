import mysql.connector

my_con = mysql.connector.connect(
    host="remotemysql.com",
    user="",
    passwd="",
    database=""
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
    cursor.execute("""INSERT INTO characters (id, fName, lName, popularity, animeFK) VALUES (503680, 'Thanapat', 'IG: kun.tnp', 9999, 11)""")
    my_con.commit()
    print("INSERT SUCCESS\n")
except:
    print("INSERT FAIL\n")

print("[1.5]")
# 1.5
cursor.execute("SELECT * FROM characters INNER JOIN anime ON characters.animeFK = anime.id AND characters.id = '503680'")
for x in cursor:
    print(x[0], x)

cursor.close()
my_con.close()