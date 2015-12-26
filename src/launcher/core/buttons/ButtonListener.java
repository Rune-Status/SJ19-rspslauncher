package launcher.core.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import launcher.Configuration;
import launcher.core.Checksum;
import launcher.core.Client;
import launcher.core.Frame;
import launcher.update.Update;
import launcher.utility.Utility;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand().toLowerCase();
		switch (command) {
		case "play now":
			if (!Checksum.isClientUpToDate()) {
				JOptionPane.showMessageDialog(null, "Your client is outdated, press fetch update.", "Launcher", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (!Checksum.isCacheUpToDate()) {
				JOptionPane.showMessageDialog(null, "Your cache is outdated, press fetch update.", "Launcher", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			Client.runClient();
			break;
		case "fetch update":
			Frame.label.setText("Checking for updates...");
			Update.check();
			break;
		case "forums":
			Utility.browse(Configuration.FORUM_URL);
			break;
		case "vote":
			Utility.browse(Configuration.VOTE_URL);
			break;
		case "store":
			Utility.browse(Configuration.STORE_URL);
			break;
		default:
			System.out.println("Unhandled command: " + command);
			break;
		}
	}
}