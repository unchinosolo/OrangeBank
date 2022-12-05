package Interfaces

import repositorios.UsuarioRepo

interface AutenticacionUsuario {

    //METODOS A IMPLEMENTAR

    fun nickValidation(nickname: String): Boolean {
        var nickCorrecto = false;
        for (cuenta in UsuarioRepo.usuarios) {
            if (cuenta.usuario.equals(nickname)) {
                nickCorrecto = true
                return nickCorrecto

            }
        }
        return nickCorrecto
    }

    fun passValidation(password: String): Boolean {
        var passwordVerificada = false
        for (cuenta in UsuarioRepo.usuarios) {
            if (cuenta.password.equals(password)) {
                passwordVerificada = true
                return passwordVerificada

            }
        }
        return passwordVerificada
    }
}