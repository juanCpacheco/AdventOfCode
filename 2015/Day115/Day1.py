#Day1 Not Quite Lisp

#Reterna el valor de la posicion actual en la que termina Santa comenzando en 0, aumentando 1 en '(' y disminuyendo 1 en ')'
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day115\\input.txt')
piso = 0
for caracter in archivo.read():
    if caracter == '(':
        piso+=1
    else:
        piso-=1
print("Piso resultante puzzle 1: ", piso)
archivo.close()

#Retorna la posicion+1 de la instruccion '(' o ')' que hace que actualPos sea -1, es decir el momento en el que santa llega al sotano
archivo = open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2015\\Day115\\input.txt')
piso = 0
for i, caracter in enumerate(archivo.read(), 1):
    if caracter == '(':
        piso+=1
    else:
        piso-=1
    if(piso == -1):
        print("La posicion del primer comando que lo hace llegar al sotano es: ", i)
        break
archivo.close()
