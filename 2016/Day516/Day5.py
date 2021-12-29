import hashlib
#Day5 How About a Nice Game of Chess?

#Se desea conocer un codigo de 8 digitos. Cada digito es el 6 caracter de un hash MD5 que en hexadecimal comienza por 5 ceros siendo la entrada el input + num (los primeros 8 enteros que cumplan en orden seran la clave).
input = "uqwqemis"
clave = ''
i = 0
while len(clave) < 8:
    hashmd5 = hashlib.md5()
    actual = input + str(i)
    hashmd5.update(actual.encode())
    hexadecimal = hashmd5.hexdigest()
    if(hexadecimal.startswith("00000")):
        clave += hexadecimal[5]
    i += 1
print(clave)


#Instead of simply filling in the password from left to right, the hash now also indicates the position within the password to fill.
#You still look for hashes that begin with five zeroes; however, now, the sixth character represents the position (0-7), and the seventh character is the character to put in that position.
#A hash result of 000001f means that f is the second character in the password. Use only the first result for each position, and ignore invalid positions.
input = "uqwqemis"
clave = [None]*8
digitosResueltos = 0 
i = 0
while digitosResueltos < 8:
    hashmd5 = hashlib.md5()
    actual = input + str(i)
    hashmd5.update(actual.encode())
    hexadecimal = hashmd5.hexdigest()
    if(hexadecimal.startswith("00000")):
        numero = hexadecimal[5]
        if numero.isnumeric() and int(numero)<8 and clave[int(numero)] == None:
            clave[int(numero)] = hexadecimal[6]
            digitosResueltos += 1
    i += 1
print(''.join(clave))
