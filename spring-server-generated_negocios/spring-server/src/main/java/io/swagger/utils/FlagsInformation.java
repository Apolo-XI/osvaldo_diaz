package io.swagger.utils;

public class FlagsInformation {
	
	// -------------- BANDERAS PARA DATOS INCORRECTOS
    public final String MSN_CODE_0001 = "CAMPO NOMBRE VACIO O INCORRECTO";
        public final String CODE_0001 = "0001";
    public final String MSN_CODE_0002 = "CAMPO APELLIDOS VACIO O INCORRECTO";
        public final String CODE_0002 = "0002";
    public final String MSN_CODE_0003 = "CAMPO CORREO VACIO O INCORRECTO";
        public final String CODE_0003 = "0003";
    public final String MSN_CODE_0004 = "CAMPO CONTRASEÑA VACIO O INCORRECTO";
        public final String CODE_0004 = "0004";
	

        //--------------- BANDERAS PARA ID
        public final String MSN_CODE_1001 = "ID NO ENCONTRADO";
            public final String CODE_1001 = "1001";
        public final String MSN_CODE_1002 = "ID YA REGISTRADO";
            public final String CODE_1002 = "1002";
	
	//--------------- BANDERAS PARA ROL
	public final String MSN_CODE_2001 = "ROL NO ENCONTRADO";
		public final String CODE_2001 = "2001";
	
	//--------------- BANDERAS PARA ESTADO
	public final String MSN_CODE_3001 = "ESTADO NO ENCONTRADO";
		public final String CODE_3001 = "3001";
		
	//--------------- BANDERAS PARA USUARIOS
	public final String MSN_CODE_4001 = "USUARIO EXISTENTE";
		public final String CODE_4001 = "4001";
	public final String MSN_CODE_4002 = "USUARIO NO EXISTENTE";
		public final String CODE_4002 = "4002";
		

	//--------------- BANDERAS PARA CONEXION CON BASES DE DATOS
		public final String MSN_CODE_5001 = "NO HAY CONEXION CON BASE DE DATOS";
			public final String CODE_5001 = "5001";
			
		public final String MSN_CODE_5002 = "PERMISO DENEGADO";
			public final String CODE_5002 = "5002";

	//--------------- BANDERAS PARA CORREOS
			public final String MSN_CODE_6001 = "CORREO YA REGISTRADO";
		        public final String CODE_6001 = "6001";
	//--------------- BANDERAS PARA TOKENS
		        public final String MSN_CODE_8001 = "TOKEN NO REGISTRADO";
		        public final String CODE_8001 = "8001";
		
		//--------------- BANDERA PARA SUPERADMINMASTER   
	    public final String SUPERADMINMASTER = "SUPERADMINMASTER";
	        public final String SUPERADMINMASTER_ERROR_MSN = "NO ES POSIBLE REGISTRAR MÁS SUPERADMINMASTER";
	        public final String SUPERADMINMASTER_ERROR_CODE = "7001";
	        
	        public final String SUPERADMINMASTER_ELIMINAR_MSN = "NO ES POSIBLE ELIMINAR EL SUPERADMINMASTER";
	        public final String SUPERADMINMASTER_ELIMINAR_ERROR_CODE = "7002";
	        
	        public final String SUPERADMINMASTER_EDITAR_MSN = "NO ES POSIBLE EDITAR EL SUPERADMINMASTER";
	        public final String SUPERADMINMASTER_EDITAR_ERROR_CODE = "7003";
		
	//--------------- BANDERA PARA SUPERADMIN
	public final String SUPERADMIN = "SUPERADMIN";
	
	//--------------- BANDERA PARA ADMIN
	public final String ADMIN = "ADMIN";
	
	//--------------- BANDERA PARA USER
	public final String USER = "USER";
}