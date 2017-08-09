# Sublime Text 3
The king of modern development!

## Resources
* `/\*(.)*\**/` The regular expression to target all your one line comments wrapped with /\*this\*/. Learn more about the [Perl regular expressions](http://www.boost.org/doc/libs/1_44_0/libs/regex/doc/html/boost_regex/syntax/perl_syntax.html) that power it.
* Keep your installed packages "synced" across machines by saving the necessary files to github. Follow the [official documentation](https://packagecontrol.io/docs/syncing). Install the one that makes `Ctrl + Alt + Shift + T` open a terminal window!
* A [REPL](https://packagecontrol.io/packages/SublimeREPL) might be useful!

## Package Manager:
Command to install package manager from Sublime's commandline (Ctrl + ` even on Mac):

import urllib.request,os,hashlib; h = 'df21e130d211cfc94d9b0905775a7c0f' + '1e3d39e33b79698005270310898eea76'; pf = 'Package Control.sublime-package'; ipp = sublime.installed_packages_path(); urllib.request.install_opener( urllib.request.build_opener( urllib.request.ProxyHandler()) ); by = urllib.request.urlopen( 'http://packagecontrol.io/' + pf.replace(' ', '%20')).read(); dh = hashlib.sha256(by).hexdigest(); print('Error validating download (got %s instead of %s), please try manual install' % (dh, h)) if dh != h else open(os.path.join( ipp, pf), 'wb' ).write(by)