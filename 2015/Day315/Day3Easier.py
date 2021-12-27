#Day3 Perfectly Spherical Houses in a Vacuum

#Se desea conocer por cuantos puntos paso santa al menos una vez segun las instrucciones del input
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day315\\input.txt')
posicion = (0,0)
visitados = set()
visitados.add(posicion)
for caracter in archivo.read():
    x, y = posicion
    if caracter == '^':
        posicion = (x, y+1)
    elif caracter == '<':
        posicion = (x-1, y)
    elif caracter == '>':
        posicion = (x+1, y)
    else:
        posicion = (x, y-1)
    visitados.add(posicion)
archivo.close()
print(len(visitados))

#Se desea conocer por cuantos puntos pasaron santa o el robot al menos una vez segun las instrucciones del input
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day315\\input.txt')
posiciones = [(0,0), (0,0)]
visitados = set()
visitados.add(posiciones[0])
visitados.add(posiciones[1])

for i, caracter in enumerate(archivo.read(), 1):
    x, y = posiciones[i%2]
    if caracter == '^':
        posiciones[i%2] = (x, y+1)
    elif caracter == '<':
        posiciones[i%2] = (x-1, y)
    elif caracter == '>':
        posiciones[i%2] = (x+1, y)
    else:
        posiciones[i%2] = (x, y-1)
    visitados.add(posiciones[i%2])
archivo.close()
print(len(visitados))