import org.codehaus.groovy.control.CompilerConfiguration

/**
 * @author Evgenii_Lartcev (created on 12/6/2016).
 */
abstract class MyBaseClass extends Script {
    String name
    public void greet() { println "Hello, $name!" } //$ - use it instead getters and setters
}

def config = new CompilerConfiguration()
config.scriptBaseClass = 'MyBaseClass'
def shell = new GroovyShell(this.class.classLoader, config)
//active command with printing
shell.evaluate """
    setName 'Judith'                                                    
    greet()
"""
