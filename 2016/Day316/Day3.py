#Se desea conocer el numero de triangulos posibles del archivo donde cada linea indica los 3 lados1 del triangulo.
#Un triangulo es posible si la suma de dos lados cualquiera es mayor al tercer lado.
posibles = 0
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day316\\input.txt')
for line in archivo.readlines():
    lado1, lado2, lado3 = map(int, line.split())
    if lado1 + lado2 > lado3 and lado1 + lado3 > lado2 and lado2 + lado3 > lado1:
        posibles += 1
print(posibles)
archivo.close()

#Ahora se desea conocer el numero de triangulos posibles del archivo donde cada grupo vertical de tres valores indica los 3 lados del triangulo.
posibles = 0
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day316\\input.txt')
linea = archivo.readline().split()
while(len(linea) > 0):
    x1,y1,z1 = map(int,linea)
    x2,y2,z2 = map(int,archivo.readline().split())
    x3,y3,z3 = map(int,archivo.readline().split())
    if x1 + x2 > x3 and x1 + x3 > x2 and x2 + x3 > x1:
        posibles += 1
    if y1 + y2 > y3 and y1 + y3 > y2 and y2 + y3 > y1:
        posibles += 1
    if z1 + z2 > z3 and z1 + z3 > z2 and z2 + z3 > z1:
        posibles += 1
    linea = archivo.readline().split()
print(posibles)
archivo.close()