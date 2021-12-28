#Se desea conocer la clave de 5 digitos los cuales se descubren al seguir cada linea correspondiente del input donde: 
# U indica un movimiento hacia arriba, D hacia abajo, R hacia la derecha y L hacia la izquierda
# Partiendo desde 5 en un tablero de digitos 3x3.
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day216\\input.txt')
clave = ''
tablero = [(1,2,3),(4,5,6),(7,8,9)]
posicion = (1,1)
for line in archivo.readlines():
    for instruccion in line.strip():
        if instruccion == 'U':
            posicion = (max(0,posicion[0]-1), posicion[1])
        elif instruccion == 'D':
            posicion = (min(2,posicion[0]+1), posicion[1])
        elif instruccion == 'R':
            posicion = (posicion[0], min(2, posicion[1]+1))
        else:
            posicion = (posicion[0], max(0, posicion[1]-1))
        actual = str(tablero[posicion[0]][posicion[1]])
    clave += actual
print(clave)
archivo.close()

#Lo mismo pero con este tablero:
#    1
#  2 3 4
#5 6 7 8 9
#  A B C
#    D
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day216\\input.txt')
clave = ''
tablero = [(0,0,1,0,0),(0,2,3,4,0),(5,6,7,8,9),(0,'A','B','C',0),(0,0,'D',0,0)]
posicion = (2,0)
actual = str(5)
for line in archivo.readlines():
    for instruccion in line.strip():
        if instruccion == 'U':
            if actual not in '52149':
                posicion = (posicion[0]-1, posicion[1])
        elif instruccion == 'D':
            if actual not in '5ADC9':
                posicion = (posicion[0]+1, posicion[1])
        elif instruccion == 'R':
            if actual not in '14DC9':
                posicion = (posicion[0], posicion[1]+1)
        else:
            if actual not in '5AD12':
                posicion = (posicion[0], posicion[1]-1)
        actual = str(tablero[posicion[0]][posicion[1]])
    clave += actual
print(clave)
archivo.close()