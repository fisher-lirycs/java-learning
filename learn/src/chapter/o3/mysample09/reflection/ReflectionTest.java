package chapter.o3.mysample09.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

	public static void main(String[] args) throws ClassNotFoundException {
		String name = "chapter.o3.mysample09.Manager";
		Class cl = Class.forName(name);
		String modifiers = Modifier.toString(cl.getModifiers());
		if (modifiers.length() > 0) {
			System.out.print(modifiers + " ");
		}
		
		if (cl.isSealed()) {
			System.out.print("sealed ");
		}
		
		if (cl.isEnum()) {
			System.out.print("enum " + name);
		} else if (cl.isRecord()) {
			System.out.print("record " + name);
		} else if (cl.isInterface()) {
			System.out.print("interface " + name);
		} else {
			System.out.print("class " + name);
		}
		
		Class supercl = cl.getSuperclass();
		if(supercl != null && supercl !=Object.class) {
			System.out.print(" extends " + supercl.getName());
		}
		printInterfaces(cl);
		printPermittedSubclasses(cl);
		System.out.print("\n{\n");
		
		printConstructors(cl);
		System.out.println();
		System.out.println();
		printFields(cl);
		System.out.println();
		printMethods(cl);
		System.out.println("}");
	}
	
	public static void printConstructors(Class cl) {
		Constructor[] constructors  = cl.getDeclaredConstructors();
		for(Constructor c:constructors) {
			String name = c.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(name + "(");
			Class[] paramTypes = c.getParameterTypes();
			for(int j = 0; j < paramTypes.length; j++) {
				if(j > 0) {
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.print(")");
		}
	}
	
	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		for(Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(retType.getName() + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();
			for(int j=0; j < paramTypes.length; j++) {
				if(j > 0) {
					System.out.print(",");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
			System.out.println();
		}
	}

	public static void printFields(Class cl) {
		Field[]fields = cl.getDeclaredFields();
		for(Field f : fields) {
			Class type = f.getType();
			String name =f.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.println(type.getName() + " " + name + ";");
		}
	}
	
	public static void printPermittedSubclasses(Class cl) {
		if(cl.isSealed()) {
			Class<?>[] permittedSubclasses = cl.getPermittedSubclasses();
			for(int i = 0; i < permittedSubclasses.length; i++) {
				if(i == 0) {
					System.out.print("permits ");
				} else {
					System.out.print(",");
				}
				System.out.print(permittedSubclasses[i].getName());
			}
		}
	}
	
		public static void printInterfaces(Class cl) {
			Class<?>[]interfaces = cl.getInterfaces();
			for(int i = 0; i < interfaces.length; i++) {
				if (i == 0) {
					System.out.print(cl.isInterface() ? " extends " : " implements ");
				} else {
					System.out.print(",");
				}
				System.out.print(interfaces[i].getName());
			}
	}
}
