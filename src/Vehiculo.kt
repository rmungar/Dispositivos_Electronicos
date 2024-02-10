interface Vehiculo {
    var motorEncendido: Boolean
    var kmh : Int
    /**
     * Modifica un valor y retorna un string
     * @param vel -> Entero que representa la velocidad del vehículo
     * @return String con los datos anteriores
     */
    fun acelerar(vel: Int): String{
        kmh += vel
        return "Acelerando hasta $kmh Kilométros/Hora"
    }
    /**
     * Modifica un valor y retorna un string
     * @param vel -> Entero que representa la velocidad del vehículo
     * @return String con los datos anteriores
     */
    fun frenar(vel: Int): String{
        kmh -= vel
        return "Frenando hasta $kmh Kilométros/Hora"
    }
}