/*
 * Copyright 2018 ICON Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package foundation.icon.icx;

import foundation.icon.icx.crypto.KeystoreException;
import foundation.icon.icx.data.Bytes;
import foundation.icon.icx.data.CommonData;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Log4j
public class WalletExample {

	private static final String PASSWORD = "P@ssw0rd";

	private static void print(KeyWallet wallet) {
		System.out.println("address: " + wallet.getAddress());
		System.out.println("privateKey: " + wallet.getPrivateKey().toHexString(false));
		System.out.println();
	}

	public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
			NoSuchProviderException,  IOException, KeystoreException {

		String dirPath = "./";
		// File of directory for keystore file.
		File destinationDirectory = new File(dirPath);

		// Create keyWallet and store it as a keystore file
		System.out.println("Create KeyWallet");
		KeyWallet walletOne = KeyWallet.create();
		print(walletOne);

		System.out.println("Store KeyWallet");
		String fileName = KeyWallet.store(walletOne, PASSWORD, destinationDirectory);
		System.out.println("keystore fileName: " + fileName);
		System.out.println();

		// Loads a wallet from bytes of the private key
		System.out.println("Load KeyWallet using private key");
		KeyWallet walletTwo = KeyWallet.load(new Bytes(CommonData.PRIVATE_KEY_STRING));
		print(walletTwo);

		//  Loads a wallet from a key store file
		System.out.println("Load KeyWallet using keystore file");
		File file = new File(destinationDirectory, fileName);
		KeyWallet walletThree = KeyWallet.load(PASSWORD, file);
		print(walletThree);
	}
}
