#Day2 Corruption Checksum

#For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences.
total = 0
with open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2017\\Day217\\input.txt') as archivo:
    for line in archivo.readlines():
        valores = line.split()
        valores = list(map(int,valores))
        mayor = max(valores)
        menor = min(valores)
        dif = mayor - menor
        total += dif
print('Checksum:', total)

#Find the only two numbers in each row where one evenly divides the other - that is, where the result of the division operation is a whole number. They would like you to find those numbers on each line, divide them, and add up each line's result.
total = 0
with open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2017\\Day217\\input.txt') as archivo:
    for line in archivo.readlines():
        valores = line.split()
        valores = list(map(int,valores))
        encontro = False
        for valor in valores:
            for valor2 in valores:
                if valor2 != valor:
                    if valor % valor2 == 0:
                        total+= valor/valor2
                        encontro = True
                        break
            if encontro: break
print('Suma total:', total)
