package test;

import static org.junit.Assert.*;
import main.Controller;
import main.ControlDeviceType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

	Controller myApp;
	
	@Before
	public void setUp() throws Exception {
		myApp = new Controller();
	}

	@After
	public void tearDown() throws Exception {
	}

	
//--- This section tests adding valid devices to list of controlled devices ---	
	
	@Test
	public void testAddFistValidDeviceSucceeds() {
		assertTrue("1111 ID утгийг хоосон жагсаалтанд нэмэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 2, 5, 3,4));
		assertTrue("1111 ID утга жагсаалтанд байгаа эсэх", myApp.isDeviceInList("1111"));
		assertEquals("Жагсаатанд  бүртгэлтэй төхөөрөмж байгаа эсэх", myApp.getNumDevices(), 1);
		assertEquals("Жагсаалт дүүрэн байгаа эсэх", myApp.getNumDevices(), 6);
		assertTrue("Хоосон ID-тай төхөөрөмжийн бүртгэл үүсгэж болох эсэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "", 2, 5, 3,4));
		assertTrue("Дуын төрөлтэй төхөөрөмж үүсгэж болох эсэх", myApp.addDevice("Device 01", "" , 2, 5, 3,4));
		assertTrue("Сөрөг ID (Жишээ нь -1111 ) төхөөрөмж үүсгэж болох эсэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "-1111", 2, 5, 3,4));
		assertTrue("5 оронтой ID төхөөрөмж үүсгэж болох эсэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "11111", 2, 5, 3,4));
		assertTrue("Үсэг тоо холилдсон ID  төхөөрөмж үүсгэж болох эсэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "A111", 2, 5, 3,4));
		assertTrue("Сөрөг утгатай operating-той бүртгэл үүсгэж болох эсэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", -2, 5, 3,4));
		assertTrue("1111  ID төхөөрөмжийг устгаж болох эсэх", myApp.removeDevice("1111"));
		assertTrue("ID-ны урт хоосон зай аваад устгаж болох эсэх", myApp.removeDevice(" 1111"));
		assertTrue("Тухайн бүртгэл үүсгэх ID жагсаалтанд байгаа эсэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 2, 5, 3,4));
		assertTrue("Төхөөрөмжийн safeMin нь sageMax их утгатай бүртгэл үүсгэж болох эсэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 6, 5, 3,4));
		assertTrue("Төхөөрөмжийн operatingMin нь operationMax их утгатай бүртгэл үүсгэж болох эсэх", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 2, 5, 7,4));
	}


}
