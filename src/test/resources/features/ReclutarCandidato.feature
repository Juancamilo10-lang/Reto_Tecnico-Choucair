# language: es

# Característica: Proceso de contratación de un candidato
# Este feature cubre el flujo de contratación, desde iniciar sesión hasta verificar que el candidato está creado y contratado.

Característica: Proceso de contratación de un candidato

  Como usuario autenticado,
  Quiero realizar el proceso de contratación de un candidato,
  Registrarlo y validar que el estado sea "Contratado".

  Antecedentes:
    Cuando que el usuario abra el navegador en la url
    Y inicie sesion


  Escenario: Registrar y contratar a un candidato
    Cuando navega a la pestaña de Reclutamiento
    Y hace clic en el botón Add
    Y registra los datos del candidato
    Entonces guarda los datos del candidato
    Y completa el registro de programar entrevista
    Y Marca la entrevista como aprobada
    Y realiza una oferta de trabajo
    Y realiza la contratación
    Entonces verifica que el candidato está en la lisa con estado del candidato es Contratado
