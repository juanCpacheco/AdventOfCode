#Day 4 Security Through Obscurity

#Each room consists of an encrypted name (lowercase letters separated by dashes) followed by a dash, a sector ID, and a checksum in square brackets.
#A room is real (not a decoy) if the checksum is the five most common letters in the encrypted name, in order, with ties broken by alphabetization.
#What is the sum of the sector IDs of the real rooms?

with open('C:\\Users\\JuanK\\Documents\\AdventOfCode\\2016\\Day416\\input.txt') as archivo:
    total = 0
    realRooms = []
    for linea in archivo:
        tokens = linea.strip().split('-')
        nombre = ''.join(tokens[:-1])
        nombre =  ''.join(sorted(nombre))
        masVeces = ''
        veces = 0
        es = True
        for token in tokens[-1][-6:-1]:
            for letra in nombre:
                if nombre.count(letra) > veces:
                    masVeces = letra
                    veces = nombre.count(letra)
            if masVeces == token:
                nombre = nombre.replace(masVeces, '')
                veces = 0
            else:
                es = False
                break
        if es:
            total += int(tokens[-1].split('[')[0])
            realRooms.append(linea.strip())
    print(total)

#To decrypt a room name, rotate each letter forward through the alphabet a number of times equal to the room's sector ID. A becomes B, B becomes C, Z becomes A, and so on. Dashes become spaces.
#What is the sector ID of the room where North Pole objects are stored?
def decodificar(palabra, id):
    decodificada = ''
    for letra in palabra:
        letra_unicode = ord(letra)-ord('a')
        nuevaLetra_unicode = (letra_unicode + id)%26
        decodificada += chr(ord('a')+nuevaLetra_unicode)
    return decodificada

for room in realRooms:
    tokens = str(room).strip().split('-')
    nombre = ' '.join(tokens[:-1])
    id = int(tokens[-1].split('[')[0])
    for palabra in nombre.split(' '):
        nombre = nombre.replace(palabra, decodificar(palabra, id))
    if 'northpole object storage' in nombre:
        print(nombre + ' ' + str(id))
        