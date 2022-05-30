# proy-final->AFP
AFP
Funcionalidades del sistema
* El sistema debe manejar la información de los clientes de las principales AFPS.
* Los clientes de las AFP son personas naturales dependientes de sus empleadores.
* El sistema debe permitir gestionar la vinculación a la AFP, solo debe de pertenecer a
una sola AFP. (se validará esta regla de negocio). Crear un crud con sus métodos
respectivos
* Los datos que son obligatorios al momento de la vinculación son: “nombres, apellidos,
dni, teléfono, correo, afp.
* Se debe de permitir registrar una solicitud de retiro a una AFP.
* Para registrar la solicitud se debe de tener en cuenta lo siguiente:
* La asociación de AFP les ha enviado una relación de sus clientes para cada una de las
afp (PRIMA, INTEGRA, PROFUTURO, HABITAT), conteniendo la siguiente información:
* [DNI, monto disponible, fecha retiro, nro de cta] (tenerlo presente al momento de
hacer la vinculación).
* Para registrar una solicitud se enviará la siguiente información. [dni, monto-retiro, afp]
* El api ó servicio orquestara la llamada y completara con la información que se necesite
para registrar la solicitud.
* Una persona solo puede tener asociado una AFP.
* Si el monto de retiro es mayor que el monto de retiro de la AFP se deberá mostrar un
mensaje “No se puede registrar la solicitud. Monto mayor que el permitido”.
* Los montos para retirar deben de ser mayores al 50% del monto enviado por la AFP.
Caso contrario mostrar un mensaje “Monto mínimo no cubierto por favor revise el
monto mínimo a retirar”

1. "Diagram E.R" :
![image](https://user-images.githubusercontent.com/56085495/171065402-3ba9d3e0-2f22-4e2d-93e2-4e148c0370cb.png)


