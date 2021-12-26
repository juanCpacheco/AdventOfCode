#Day3 Perfectly Spherical Houses in a Vacuum

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