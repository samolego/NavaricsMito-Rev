package org.samo_lego.navatics;

import java.lang.reflect.Field;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class NavaticsHook implements IXposedHookLoadPackage {
    private static final String IMG_URL = "https://minotar.net/helm/950a987d0d40498abe98dd17571e5e2f";
    private static final String TARGET_PACKAGE_NAME = "com.navatics.app";

    private static void log(String message) {
        XposedBridge.log("[Navatics Hook] " + message);
    }


    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) {
        if (lpparam.packageName.equals(TARGET_PACKAGE_NAME)) {
            log("Hooking into " + TARGET_PACKAGE_NAME);

            final ClassLoader classLoader = lpparam.classLoader;

            this.setupDummyAccount(classLoader);
            this.setupDevSettings(classLoader);
            this.debugConnectButton(classLoader);
        }
    }

    private void setupDevSettings(ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod("com.navatics.robot.transport.ss.d", classLoader, "s", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                log("Hooked into setupDevSettings!");

                Object self = param.thisObject;
                //XposedHelpers.setBooleanField(self, "c", false);  // this.enableAuth = false;
                //XposedHelpers.setBooleanField(self, "d", true);  // this.enableSimulateSenseThinkApi = true;
                XposedHelpers.setBooleanField(self, "e", true);  // this.controllerBindResult = true;
                //XposedHelpers.setBooleanField(self, "f", true);  // this.rollerBindResult = true;
                //XposedHelpers.setBooleanField(self, "g", true);  // this.alwaysNotifySearchResult = true;
            }
        });
    }

    private void setupDummyAccount(ClassLoader classLoader) {
        XposedHelpers.findAndHookConstructor("com.navatics.app.framework.user.NvUserManager", classLoader, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                // Get the NvUserManager object that was just created
                Object self = param.thisObject;

                // Create a new NvUser object
                // Get a reference to the NvUser class
                Class<?> nvUserClass = XposedHelpers.findClass("com.navatics.app.framework.user.NvUser", classLoader);

                // Create a new NvUser object using the constructor
                Object newUser = XposedHelpers.newInstance(nvUserClass,
                        12345, // long id
                        "samo_lego", // String usrId
                        "@mejl.si", // String email
                        "samo_lego", // String nickName
                        0, // int gender
                        0, // int age
                        IMG_URL, // String usrImgLowres
                        IMG_URL, // String usrImgHighres
                        "invalid_token", // String token
                        811812 // long targetId controller code??
                );

                // Set the currentUser field of the NvUserManager object to the newUser object
                XposedHelpers.setObjectField(self, "c", newUser);
            }
        });
    }


    private void debugConnectButton(ClassLoader classLoader) {
        Class<?> nvUserClass = XposedHelpers.findClass("com.navatics.app.framework.user.NvUser", classLoader);
        XposedHelpers.findAndHookMethod("com.navatics.app.activities.HomepageActivity", classLoader, "b", nvUserClass, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                log("Hooked into connectButtonAction!");
                // Call handleUserEvent
                // Find NvUserEvent class
                Class<?> NvUserEventClass = XposedHelpers.findClass("com.navatics.app.framework.user.a", classLoader);

                // Create NvUserEvent object
                int id = 2;  // Handled in HomePageActivity#handleUserEvent
                Object nvUserEvent = XposedHelpers.newInstance(NvUserEventClass, id, param.args[0]);
                // Call handleUserEvent
                XposedHelpers.callMethod(param.thisObject, "a", nvUserEvent);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                // Print out the properties
                // Get the groundStation object
                // Find class com.navatics.app.framework.p
                Class<?> navaticsClass = XposedHelpers.findClass("com.navatics.app.framework.p", classLoader);

                // Get the groundStation object
                Object groundStation = XposedHelpers.callStaticMethod(navaticsClass, "a");

                // Log the groundStation object and its properties
                XposedBridge.log("groundStation: " + groundStation.toString());
                // Log all properties of groundStation
                for (Field field : groundStation.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    XposedBridge.log(field.getName() + ": " + field.get(groundStation));
                }

                // Log all methods of groundStation
                for (java.lang.reflect.Method method : groundStation.getClass().getDeclaredMethods()) {
                    XposedBridge.log("Method: " + method.getName());
                }

                // Log methods m4877e, m4881i
                XposedBridge.log("m4877e: " + XposedHelpers.callMethod(groundStation, "e"));
            }
        });


        Class<?> navaticsClass = XposedHelpers.findClass("com.navatics.app.framework.p", classLoader);
        XposedHelpers.findAndHookMethod("com.navatics.app.framework.p", classLoader, "j", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                log("Hooked into auhtenticateAllGroundStations!");

                // Find class com.navatics.app.framework.p
                List<?> groundStations = (List<Object>) XposedHelpers.getStaticObjectField(navaticsClass, "g");

                // Print out the groundStations object
                log("groundStations: " + groundStations.toString());

                for (Object groundStation : groundStations) {
                    // Print out the groundStation object and its properties
                    log("groundStation: " + groundStation.toString());
                    // Log all properties of groundStation
                    for (Field field : groundStation.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        log(field.getName() + ": " + field.get(groundStation));
                    }
                }
            }
        });

        XposedHelpers.findAndHookMethod("com.navatics.app.framework.p", classLoader, "a", navaticsClass, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                log("Hooked into doGroundStationAuthentication!");
                // Print out the doGroundStationAuthentication object and its properties
                log("groundStation: " + param.args[0].toString());
            }
        });

        XposedHelpers.findAndHookMethod("com.navatics.app.framework.g", classLoader, "e", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);

                // Print return value
                log("Method m4877e (e) value: " + param.getResult());
            }
        });

        // GroundStation#updateState
        XposedHelpers.findAndHookMethod("com.navatics.app.framework.g", classLoader, "a", boolean.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Object self = param.thisObject;
                Object state = XposedHelpers.getIntField(self, "f");

                log("GroundStation#updateState (PRE): " + state);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Object self = param.thisObject;
                Object state = XposedHelpers.getIntField(self, "f");

                log("GroundStation#updateState (POST): " + state);
            }
        });

        XposedHelpers.findAndHookMethod("com.navatics.app.framework.g", classLoader, "i", new XC_MethodHook() {
            /**
             * Hooks to GroundStation#updateState
             * @param param
             * @throws Throwable
             */
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // Return any other than 0 / 1
                log("Result of param: " + param.getResult());
                //param.setResult(4);
            }
        });

        // com.navatics.robot.transport.e.class
        Class<?> transportClass = XposedHelpers.findClass("com.navatics.robot.transport.e", classLoader);
        XposedHelpers.findAndHookMethod("com.navatics.app.framework.p", classLoader, "c", transportClass, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                log("Setup GroundStation called!");
            }
        });

        // Controller
        XposedHelpers.findAndHookMethod("com.navatics.robot.transport.ss.d", classLoader, "o", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // Return true
                //param.setResult(true);
            }
        });

        XposedHelpers.findAndHookMethod("com.navatics.app.framework.g", classLoader, "c", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // Return true
                //param.setResult(true);
            }
        });

        // Logging
        XposedHelpers.findAndHookMethod("org.apache.log4j.c", classLoader, "c", java.lang.Object.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                // Log arg 0
                log("Log4j: " + param.args[0]);
            }
        });

        // Category#conditionalLog2
        XposedHelpers.findAndHookMethod("org.apache.log4j.c", classLoader, "d", java.lang.Object.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                // Log arg 0
                log("Log4j-2: " + param.args[0]);
            }
        });

        XposedHelpers.findAndHookMethod("org.apache.log4j.c", classLoader, "b", java.lang.Object.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                // Log arg 0
                log("Log4j-3: " + param.args[0]);
            }
        });
    }
}