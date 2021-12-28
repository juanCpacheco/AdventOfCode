
def getName():
    respuesta = 'siguiente'
    return respuesta

print("Hello world")
print(getName())

palabra = 'zixmtkozy'
decodificada = ''
for letra in palabra:
    letra_unicode = ord(letra)-ord('a')
    nuevaLetra_unicode = (letra_unicode + 343)%26
    decodificada += chr(ord('a')+nuevaLetra_unicode)
print(decodificada)