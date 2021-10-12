# assistant
Asistente de contratación en memoria que ofrezca al cliente la combinación de servicios más económica, que es aquella cuya media de los importes es mínima.

## Consideraciones
* List<Services> searchMinimalAmount(): devuelve la primera combinación más económica del listado de servicios.
* void add(Service service): antes de añadir un servicio al listado comprueba que no existe uno con el mismo nombre.
