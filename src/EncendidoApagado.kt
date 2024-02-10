interface EncendidoApagado {
    /**
     * Retorna un string
     * @return String
     */
    fun encender(): String{
        return "Se ha encendido el dispositivo"
    }
    /**
     * Retorna un string
     * @return String
     */
    fun apagar(): String{
        return "Se ha apagado el dispositivo"
    }
}