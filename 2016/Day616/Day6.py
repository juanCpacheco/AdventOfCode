#Day6 Probably a Fire Hazard
#Se desea conocer las claves secretas conformadas por la letra que mas y menos se repite respectivamente de cada columna del input 

columnas = [[] for i in range(8)]

with open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day616\\input.txt') as archivo:
    for line in archivo.readlines():
        line = line.rstrip()
        for i in range(8):
            columnas[i].append(line[i])

clave = ''
clave2 = ''
for columna in columnas:
    columna.sort()
    letras = ''.join(columna)
    masRepetido = ''
    masVeces = 0
    menosRepetido = ''
    menosVeces = len(letras)
    i = 0
    while(i < len(letras)):
        cont = letras.count(letras[i])
        if cont > masVeces:
            masVeces = cont
            masRepetido = letras[i]
        if cont < menosVeces:
            menosVeces = cont
            menosRepetido = letras[i]
        i += cont
    clave += masRepetido
    clave2 += menosRepetido
print(clave)
print(clave2)