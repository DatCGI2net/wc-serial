#!/usr/bin/perl
use strict;
### show word with count
my $max=2000;
if(@ARGV) < 2){
	print "\nPlease specify the count.\n For example, $0 [output.txt] 2000\n";
	
}
$max=$ARGV[1];
open(my $fh,"<$ARGV[0]") or die "Could not open ouput $ARGV[0] file. Reason:" . $!;

foreach(<$fh>){
	chomp;
	my $c=0;
	
	if(/(\d+)$/){
		$c=$1;
	}
	next if $c < $max;
	
	print "$_\n";
}

close($fh);
