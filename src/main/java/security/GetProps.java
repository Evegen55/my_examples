package security;/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.lang.*;
import java.security.*;

class GetProps {

    /*
    Copy this file in the c:\Test\ folder (Windows)
    next Navigate to the folder
    next try it with with -Djava.security.manager VM parameter
    You probably see next lines:
            "break in console is not supported due to security permissions: access denied ("java.util.PropertyPermission" "idea.launcher.bin.path" "read")
            Exception in thread "main" java.security.AccessControlException: access denied ("java.lang.reflect.ReflectPermission" "suppressAccessChecks")"
    Then copy \main\resources\examplepolicy file in the c:\Test\ folder
    Try it run with -Djava.security.manager -Djava.security.policy=examplepolicy VM parameters
    It must allow to get this properties. See http://docs.oracle.com/javase/tutorial/security/tour2/step4.html

     */
    public static void main(String[] args) {

        /* Test reading properties w & w/out security manager */

        String s;

        try {

            System.out.println("About to get os.name property value");

            s = System.getProperty("os.name", "not specified");
            System.out.println("  The name of your operating system is: " + s);

            System.out.println("About to get java.version property value");

            s = System.getProperty("java.version", "not specified");
            System.out.println("  The version of the JVM you are running is: " + s);

            System.out.println("About to get user.home property value");

            s = System.getProperty("user.home", "not specified");
            System.out.println("  Your user home directory is: " + s);

            System.out.println("About to get java.home property value");

            s = System.getProperty("java.home", "not specified");
            System.out.println("  Your JRE installation directory is: " + s);


        } catch (Exception e) {
            System.err.println("Caught exception " + e.toString());
        }

    }

}


