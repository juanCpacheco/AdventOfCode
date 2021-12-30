
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2017\\Day117\\input.txt')
linea = archivo.readline().strip()
archivo.close()

#Day1 Inverse Captcha
#Find the sum of all digits that match the next digit in the list
total = 0
for i in  range(len(linea)):
    primero = int(linea[i])
    if i != len(linea)-1:
        segundo = int(linea[i+1])
    else:
        segundo = int(linea[0]) 
    if primero == segundo:
        total += primero
print(total)

#Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list.
#That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. 
total = 0
posSeg = 0
for i in  range(len(linea)):
    primero = int(linea[i])
    pasos = len(linea)//2
    if i < len(linea)-pasos:
        segundo = int(linea[i+pasos])
    else:
        segundo = int(linea[posSeg])
        posSeg += 1
    if primero == segundo:
        total += primero
print(total)
