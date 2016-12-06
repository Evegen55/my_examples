/**
 * @author Evgenii_Lartcev (created on 12/6/2016).
 * @see <a href = "http://docs.groovy-lang.org/docs/latest/html/documentation/core-domain-specific-languages.html">Link to a page</a>
 */
def binding = new Binding()
def shell = new GroovyShell(binding)
binding.setVariable('x',1)
binding.setVariable('y',3)
shell.evaluate 'z=2*x+y'
assert binding.getVariable('z') == 5
println binding.getVariable('z')
