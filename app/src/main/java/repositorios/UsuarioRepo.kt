package repositorios

import dataClass.Usuario

object UsuarioRepo {

    val usuarios = mutableListOf<Usuario>()

    init {
        val usuario1: Usuario = Usuario("Lucho", "1234", 1)
        val usuario2: Usuario = Usuario("Maria", "4321", 2)
        val usuario3: Usuario = Usuario("Eze", "4789", 3)

        usuarios.add(usuario1)
        usuarios.add(usuario2)
        usuarios.add(usuario3)

    }
}