ELO Adapter
===========

Notes
-----

As `uid`, both ELO `id` or `guid` can be used.

Triggers
--------

**ReadDir**

Reads a directory and list its children.


**ReadDoc**

Reads a document and provides a download URL

Actions
-------

**CreateDoc**

Given an input URL, fetch and upload it as new document in the archive.
Returns the `id`.

**CreateDir**

Creates a directory.

**DeleteAny**

Deletes a directory or document.

**UpdateDoc**

Given a URL, fetch and upload it as new document version.

**UpdateObj**

Updates label or description of a directory or document.



Notes
-----

This is still gradle 2.0!!!

Using more recent versions of gradle lead to errors:

https://github.com/elasticio/petstore-component-java/issues/8


...trying to update to java 11 also lead to a fiasco since their docker containers are all stuck in the past.