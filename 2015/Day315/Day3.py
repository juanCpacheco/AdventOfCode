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
posicionSanta = (0,0)
posicionRobot = (0,0)
visitados = set()
visitados.add(posicionSanta)
visitados.add(posicionRobot)
for i, caracter in enumerate(archivo.read(), 1):
    if(i%2 == 0):
        x, y = posicionSanta
        if caracter == '^':
            posicionSanta = (x, y+1)
        elif caracter == '<':
            posicionSanta = (x-1, y)
        elif caracter == '>':
            posicionSanta = (x+1, y)
        else:
            posicionSanta = (x, y-1)
        visitados.add(posicionSanta)
    else:
        x, y = posicionRobot
        if caracter == '^':
            posicionRobot = (x, y+1)
        elif caracter == '<':
            posicionRobot = (x-1, y)
        elif caracter == '>':
            posicionRobot = (x+1, y)
        else:
            posicionRobot = (x, y-1)
        visitados.add(posicionRobot)
archivo.close()
print(len(visitados))